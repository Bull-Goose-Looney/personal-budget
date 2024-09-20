// src/services/api.js
import axios from 'axios';

const API_URL = "http://localhost:8080/api/lineitem"; // Backend URL

export const fetchLineItemsByCategory = async () => {
  try {
    const response = await axios.get(`${API_URL}/getAllByCategory`);
    return response.data;
  } catch (error) {
    console.error("Error fetching users:", error);
    throw error;
  }
};
