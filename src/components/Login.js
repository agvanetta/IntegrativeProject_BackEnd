import React from "react";
import "./Login.css";
import { Link } from "react-router-dom";

function Login() {
  return (
    <div className="login">
      <Link to="/">
        <img
          className="login__logo"
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJXHlVyH0mWe1dqnbwJvorD0i9rgwELdXNE615qU0DX4lWkEi21ENgcd2quoVXSxC9gko&usqp=CAU"
          alt=""
        />
      </Link>
      <div className="login__container">
        <h1 >Sing in</h1>
        <form>
          <h5>User</h5>
          <input type="email" className="password"/>
          <h5>Password</h5>
          <input type="password" className="password"/>
          <Link to="/" type="submit" className="login__singInButton">
            <button to="/" type="submit" className="login__singInButton">
              Sing In
            </button>
          </Link>
        </form>
       
      </div>
    </div>
  );
}

export default Login;
