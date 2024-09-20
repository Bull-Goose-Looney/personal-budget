// src/services/api.js
import axios from 'axios';

const API_URL = "http://localhost:8080/api/category"; // Backend URL

export const fetchLineItemsByCategory = async () => {
  try {
    const response = await axios.get(`${API_URL}/categories`);
    return response.data;
  } catch (error) {
    console.error("Error fetching users:", error);
    throw error;
  }
};
