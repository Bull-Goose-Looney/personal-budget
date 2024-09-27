//g src/services/api.js
import axios from 'axios';

const LINE_ITEM_API_URL = "http://localhost:8080/api/lineitem"; // Backend URL

export const fetchLineItemsByCategory = async () => {
  try {
    const response = await axios.get(`${LINE_ITEM_API_URL}/getallbycategory`);
    return response.data;
  } catch (error) {
    console.error("Error fetching users:", error);
    throw error;
  }
};

export const fetchLineItemsByName = async () => {
  try {
    const response = await axios.get(`${LINE_ITEM_API_URL}/getbyname`);
    return response.data;
  } catch (error) {
    console.error("Error fetching users:", error);
    throw error;
  }
};

// TODO, implement API call in backend for this
export const updateLineItem = async (lineItemId, updatedData) => {
  try {
    const response = await axios.put(`${API_URL}/${lineItemId}`, updatedData);
    return response.data;
  } catch (error) {
    console.error('Error updating line item:', error);
    throw error;
  }
};

// More LineItem-related service functions can go here
