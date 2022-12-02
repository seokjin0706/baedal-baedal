import client from './client';

export const login = ({ id, passWord }) =>
  client.post('/api/auth/login', { id, passWord });

export const register = ({ id, passWord }) =>
  client.post('/api/auth/register', { id, passWord });

export const check = () => client.get('/api/auth/register');
