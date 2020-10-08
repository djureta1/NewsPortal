import axios from "axios";
import React, { useState } from "react";
import "../index.css"


const Login = ({  ...props }) => {


    const [user,setUser]=useState({
        username:"",
        password:""
    })

    function handleFieldChange(e, setUser) {
        const { name, value } = e.target;
        setUser(prevState => ({
            ...prevState,
            [name]: value
        })
        )
    }

    function login(){

        axios.post("http://localhost:8080/login",user)
        .then(response =>{
            if(response.data.success){
                localStorage.logged=true;
                localStorage.id=response.data.userId;
                window.location.href="/admin";
            }else {
                alert(response.data.message);
            }
        })
        .catch(error=>{
            alert("Login failed.");
        })
    }


    return (
        <div className="loginMain">
        <div className="login" >
            
            <h1>Login</h1>
            <label className="label">Username:</label>
            <input id="username" name="username" type="text" onChange={(e) => handleFieldChange(e, setUser)} />
            <label className="label">Password:</label>
            <input id="password" name="password" type="text" onChange={(e) => handleFieldChange(e, setUser)} />
            <button className="btn" type="button" onClick={()=>login()}>Login</button>
            
        </div>
        </div>
    );
}

export default Login;