import API from "./axiosConfig";

export const getShowsByMovie = movieId =>
  API.get(`/shows?movieId=${movieId}`);
