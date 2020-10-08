import axios from "axios";
import React, { useState } from "react";
import "../index.css"


const AddNews = ({  ...props }) => {


    const [news,setNews]=useState({
        caption:"",
        text:"",
        date:null,
        userId:localStorage.id
    })

    function handleFieldChange(e, setNews) {
        const { name, value } = e.target;
        setNews(prevState => ({
            ...prevState,
            [name]: value
        })
        )
    }

    function save(){

        axios.post("http://localhost:8080/news",news)
        .then(response =>{
            alert("News added.")
        })
        .catch(error=>{
            alert("News is not added.");
        })
    }

    function back(){
        window.location.href="/admin";
    }


    return (
        <div className="loginMain">
        <div className="login" >
            
            <h1>Add News</h1>
            <label className="label">Caption:</label>
            <input id="caption" name="caption" type="text" onChange={(e) => handleFieldChange(e, setNews)} />
            <label className="label">Text:</label>
            <textarea id="text" name="text" rows="10" cols="50" onChange={(e) => handleFieldChange(e, setNews)}></textarea>
            <button className="btn" type="button" onClick={()=>save()}>Save</button>
            <button className="btn" type="button" onClick={()=>back()}>Back</button>
            
        </div>
        </div>
    );
}

export default AddNews;