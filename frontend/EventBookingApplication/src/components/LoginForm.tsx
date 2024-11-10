import React, { useState, useContext } from 'react';
import { LoginService } from '../services/LoginService';
import { AuthContext } from '../context/AuthContext';

interface LoginProps {
  onLoginSuccess: () => void; // Define the prop for handling login success
}

const LoginForm: React.FC<LoginProps> = ({ onLoginSuccess }) => {
  const { saveToken } = useContext(AuthContext)!; 
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(false);

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    if (!username || !password) {
      setError("Both fields are required.");
      return;
    }

    try {
      setLoading(true);
      const token: string = await LoginService.login({username,password});
      console.log(token)

      if(token != null && token.length>0){
        saveToken(token)
      }
      
      onLoginSuccess();
    } catch (error) {
      console.error('Error logging in user:', error);

    } finally {
      setLoading(false);
    }

  };

  if (loading) return <p>Loading...</p>;

  return (
    <form onSubmit={handleLogin}>
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
            <button type="submit" >Login</button>
        </div>
    </form>
  );
};

export default LoginForm;