import React from "react";
import "../index.css";
import axios from "axios"
import { useEffect, useState } from "react";

const Admin = ({  ...props }) => {

    const [news,setNews] = useState([])
    useEffect(()=>{
        if(localStorage.logged){
        axios.get("http://localhost:8080/user/"+localStorage.id+"/news")
        .then(response =>{
            setNews(response.data)
        })
        .catch(error=>{

        })
    }else{
        window.location.href="/home";
    }
    },[])

    const listNews = news.map((item)=>
        <tr>
            <td>{item.caption}</td>
            <td>{item.dateOfCreation}</td>
        </tr>
    )

    function logout(){
        localStorage.logged=false;
        localStorage.id=null;
        window.location.href="/home";
    }

    function addNews(){
        window.location.href="/addnews";
    }


    return (

        <div className="admin" >
            <div className="header">
            <h1>Admin page</h1>
            <button className="btn" type="button" onClick={()=>logout()}>Logout</button>
            </div>
            <table>
                <tr>
                    <th>Caption</th>
                    <th>Creation Date</th>
                </tr>
                {listNews}
            </table>

            <button className="button" type="button" onClick={()=>addNews()}>Add News</button>
            
        </div>
    );
}

export default Admin;