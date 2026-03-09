import API from "./axiosConfig";

export const loginUser = data =>
  API.post("/auth/login", null, { params: data });

export const registerUser = data =>
  API.post("/auth/register", data);
