import { useEffect,useState } from "react";
import { getMovies } from "../api/movieApi";
import MovieCard from "../components/MovieCard";

function HomePage(){
  const [movies,setMovies]=useState([]);

  useEffect(()=>{
    getMovies().then(res=>setMovies(res.data));
  },[]);

  return(
    <div className="movie-grid">
      {movies.map(m=>(
        <MovieCard key={m.id} movie={m}/>
      ))}
    </div>
  );
}
export default HomePage;
