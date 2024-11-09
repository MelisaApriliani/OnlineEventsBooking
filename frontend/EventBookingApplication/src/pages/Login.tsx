import React from 'react';
import LoginForm from '../components/LoginForm';
import '../App.css';

// const handleSubmit = async () => {
 
// };

const LoginPage: React.FC = () => (
  <div className="login-container">

    <h1>Welcome to Event Online Booking Application!</h1>
    <LoginForm />
  </div>
);

export default LoginPage;