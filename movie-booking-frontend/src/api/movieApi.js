import API from "./axiosConfig";

export const getMovies = () => API.get("/movies");
export const getMovie = id => API.get(`/movies/${id}`);
