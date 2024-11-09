import React from 'react';
import { TokenProvider } from './context/TokenContext';
import LoginPage from './pages/Login';

const App: React.FC = () => (
  <TokenProvider>
    <div id="main">
      <LoginPage />
    </div>
  </TokenProvider>
);

export default App;