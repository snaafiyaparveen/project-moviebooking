import API from "./axiosConfig";

export const createBooking = data =>
  API.post("/booking", data);
