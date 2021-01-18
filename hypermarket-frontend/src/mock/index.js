const Mock = require("mockjs");
Mock.mock("/api/list", "get", () => {
  const arr = [];
  for (let i = 0; i < 10; i++) {
    const money = Mock.mock("@float(1, 1000, 2, 2)");
    const num = Mock.mock("@integer(1, 5)");
    const obj = {
      id: Mock.mock("@id"),
      check: true,
      goodName: Mock.mock("@ctitle(5, 12)"),
      imgUrl: Mock.Random.image("80x80"),
      salePrice: money,
      num,
      subtotal: (money * num).toFixed(2)
    };
    arr.push(obj);
  }
  return arr;
});

Mock.mock("/api/search", "get", () => {
  const arr = [];
  for (let i = 0; i < 10; i++) {
    const obj = {
      id: Mock.mock("@id"),
      goodName: Mock.mock("@ctitle(5, 12)"),
      imgUrl: Mock.Random.image("200x200"),
      price: Mock.mock("@float(1, 1000, 2, 2)")
    };
    arr.push(obj);
  }
  return arr;
});

Mock.mock("/api/search/other", "get", () => {
  const arr = [];
  for (let i = 0; i < 10; i++) {
    const obj = {
      id: Mock.mock("@id"),
      goodName: Mock.mock("@ctitle(5, 12)"),
      imgUrl: Mock.Random.image("140x140"),
      price: Mock.mock("@float(1, 1000, 2, 2)"),
      comment: Mock.mock("@float(1, 100, 2, 1)")
    };
    arr.push(obj);
  }
  const newArr = cuttingData(arr);
  return newArr;
});

const cuttingData = data => {
  const proportion = 5; // 按照比例切割
  let num = 0;
  const _data = [];
  for (let i = 0; i < data.length; i++) {
    if (i % proportion == 0 && i != 0) {
      _data.push(data.slice(num, i));
      num = i;
    }
    if (i + 1 == data.length) {
      _data.push(data.slice(num, i + 1));
    }
  }
  return _data;
};
