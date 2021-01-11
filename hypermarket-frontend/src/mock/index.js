const Mock = require("mockjs");
Mock.mock("/api/list", "get", () => {
  const arr = [];
  const money = Mock.mock("@float(1, 1000, 2, 2)");
  for (let i = 0; i < 10; i++) {
    const obj = {
      id: Mock.mock("@id"),
      goodName: Mock.mock("@ctitle(5, 8)"),
      imgUrl: Mock.Random.image("80x80"),
      salePrice: money,
      num: Mock.mock("@integer(1, 5)"),
      subtotal: money
    };
    arr.push(obj);
  }
  return arr;
});
