import API from "./axiosConfig";

export const createOrder = (bookingId, amount) =>
  API.post("/payment/create-order", null, {
    params: { bookingId, amount }
  });
