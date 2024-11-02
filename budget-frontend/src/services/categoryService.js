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

export const addCategory = async () => {
  try {
    const response = await axios.get(CATEGORY_API_URL + "/add");
    return response.data;
  } catch (error) {
    console.error('Error adding new category:', error);
    throw error; // You might want to handle errors differently depending on the app
  }
};

// Add more category-related API functions here if needed (e.g., createCategory, updateCategory, etc.)
