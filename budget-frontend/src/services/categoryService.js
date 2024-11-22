// src/services/api.js
import axios from 'axios';

const CATEGORY_API_URL = "http://localhost:8080/api/category"; // Backend URL

export const fetchCategories = async () => {
  try {
    const response = await axios.get(CATEGORY_API_URL + "/categories");
    return response.data;
  } catch (error) {
    console.error('Error fetching categories:', error);
    throw error; // You might want to handle errors differently depending on the app
  }
};

const addCategory = async (newCategory) => {
  try {
    const response = await axios.post('/api/categories', newCategory, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return response.data; // Axios responses include the data in `response.data`
  } catch (error) {
    console.error('Error adding category:', error.response?.data || error.message);
    throw error;
  }
};

