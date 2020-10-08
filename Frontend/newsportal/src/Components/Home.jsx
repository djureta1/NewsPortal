import Axios from "axios";
import React, { useEffect, useState } from "react";
import "../index.css"
import axios from "axios"

const Home = ({  ...props }) => {

    const [news,setNews] = useState([])
    useEffect(()=>{
        axios.get("http://localhost:8080/news/all")
        .then(response =>{
            setNews(response.data)
        })
        .catch(error=>{

        })
    },[])

    const listNews = news.map((item)=>
        <div className="news">
            <h3>{item.caption}</h3>
            <label>{item.dateOfCreation}</label>
            <p>{item.text}</p>
        </div>
    )

    function login(){
        window.location.href="/login";
    }

    return (
        <div className="home">
            <div className="header">
            <h1>Welcome</h1>
            <button className="btn" type="button" onClick={()=>login()}>Login</button>
            </div>
            
        <div className="allnews">{listNews}</div>
        </div>
    );
}

export default Home;