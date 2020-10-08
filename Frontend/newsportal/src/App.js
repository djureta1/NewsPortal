import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Switch, Route, BrowserRouter } from "react-router-dom"
import Login from './Components/Login';
import Admin from './Components/Admin';
import Home from './Components/Home';
import AddNews from './Components/AddNews';

function App() {
  return (
    <div className="App">
     <BrowserRouter>
     <Switch>
       <Route path="/login">
          <Login />
       </Route>
       <Route path="/addnews">
         <AddNews />
       </Route>
       <Route path="/admin">
          <Admin />
       </Route>
       <Route path="/home">
          <Home />
       </Route>
     </Switch>
     </BrowserRouter> 
    </div>
  );
}

export default App;
