import React, { useState } from 'react';
import axios from 'axios';
import { useToken } from '../context/TokenContext';

const LoginForm: React.FC = () => {
  const { setToken } = useToken();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState<string | null>(null);

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    if (!username || !password) {
      setError("Both fields are required.");
      return;
    }

    try {
      const response = await axios.post(`${import.meta.env.VITE_API_URL}/login`, {
        username,
        password,
      });
      setToken(response.data.token);  // Store token globally
    } catch (err) {
      setError("Invalid username or password.");
    }
  };

  return (
        <div>
            <h2>Login</h2>
            <div className="login-form">
                <div className="form-group">
                    <label htmlFor="username">Username</label>
                    <input
                        type="email"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        placeholder="Enter username"
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Enter password"
                        required
                        />
                </div>
            </div>
            {error && <p className="error">{error}</p>}
            <button type="submit" onClick={handleLogin}>Login</button>
        </div>
  );
};

export default LoginForm;