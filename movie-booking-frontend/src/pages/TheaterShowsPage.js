import { useParams,useNavigate } from "react-router-dom";
import { getShowsByMovie } from "../api/showApi";
import { useEffect,useState } from "react";

export default function TheaterShowsPage(){
  const {movieId}=useParams();
  const [shows,setShows]=useState([]);
  const navigate=useNavigate();

  useEffect(()=>{
    getShowsByMovie(movieId).then(res=>setShows(res.data));
  },[]);

  return(
    <div>
      {shows.map(s=>(
        <button key={s.id} onClick={()=>navigate(`/seats/${s.id}`)}>
          {s.showTime}
        </button>
      ))}
    </div>
  );
}
