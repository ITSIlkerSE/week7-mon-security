import React, {useState} from 'react';
import './App.css';
import axios from "axios";

function App() {

    const [welcomeMessage, setWelcomeMessage] = useState("")
    const [password, setPassword] = useState("")
    const [username, setUsername] = useState("")

    function fetchWelcomeMessage() {
        axios.get("/api/hello")
            .then(response => {
                return response.data
            })
            .then(data => setWelcomeMessage(data))

    }

    function handleLogin() {
        axios.get("api/user/login", {auth: {username, password}})
            .then(() => setUsername(""))
            .then(() => setPassword(""))
    }

    function handleLogout(){
        axios.get("api/user/logout")
    }

    return (
        <div className="App">
            <header className="App-header">




                <h3>Login</h3>
                <input value={username} onChange={event => setUsername(event.target.value)}/>
                <input value={password} onChange={event => setPassword(event.target.value)}/>
                <button onClick={handleLogin}>Login</button>



                <button onClick={handleLogout}>Logout</button>





                <p>{welcomeMessage}</p>
                <button onClick={fetchWelcomeMessage}>Say Hello!</button>

            </header>
        </div>
    );
}

export default App;
