import { registerUser } from "../api/authApi";
import { useState } from "react";

export default function RegisterPage(){
  const [form,setForm]=useState({});

  return(
    <div>
      <input placeholder="Name"/>
      <input placeholder="Email"/>
      <input placeholder="Password"/>
      <button onClick={()=>registerUser(form)}>Register</button>
    </div>
  );
}
