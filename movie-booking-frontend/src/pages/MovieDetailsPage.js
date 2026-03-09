import { useParams } from "react-router-dom";
import { getMovie } from "../api/movieApi";
import { useEffect,useState } from "react";

export default function MovieDetailsPage(){
  const {id}=useParams();
  const [movie,setMovie]=useState({});

  useEffect(()=>{
    getMovie(id).then(res=>setMovie(res.data));
  },[]);

  return(
    <div>
      <h2>{movie.title}</h2>
      <p>{movie.description}</p>
    </div>
  );
}
