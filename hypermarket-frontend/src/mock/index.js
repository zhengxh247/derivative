const Mock = require("mockjs");
Mock.mock("/api/list", "get", () => {
  const arr = [];
  for (let i = 0; i < 5; i++) {
    const money = Mock.mock("@float(1, 1000, 2, 2)");
    const num = Mock.mock("@integer(1, 5)");
    const obj = {
      id: Mock.mock("@id"),
      check: true,
      goodName: Mock.mock("@ctitle(5, 8)"),
      imgUrl: Mock.Random.image("80x80"),
      salePrice: money,
      num,
      subtotal: (money * num).toFixed(2)
    };
    arr.push(obj);
  }
  return arr;
});
