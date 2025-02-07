//g src/services/api.js
import axios from 'axios';

const LINE_ITEM_API_URL = "http://localhost:8080/api/lineitem"; // Backend URL

// Fetch line items by category name
export const fetchLineItemsByCategory = async (categoryName) => {
  try {
    const response = await axios.get(`${LINE_ITEM_API_URL}`, {
      params: { categoryName }, // Pass categoryName as query parameter
    });

    // Check if the response data is an empty array
    if (Array.isArray(response.data) && response.data.length === 0) {
      console.warn(`No line items found for category: ${categoryName}`);
    }

    return response.data; // Return the data regardless of whether it's empty
  } catch (error) {
    console.error(
      'Error fetching line items by category:',
      error.response?.data || error.message
    );
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
    const response = await axios.put(`${LINE_ITEM_API_URL}/${lineItemId}`, updatedData);
    return response.data;
  } catch (error) {
    console.error('Error updating line item:', error);
    throw error;
  }
};

export const saveLineItem = async (lineItem) => {
  try {
    console.log("Saving line item:", lineItem);
    const response = await axios.post(`${LINE_ITEM_API_URL}/add`, lineItem);
    return response.data;
  } catch (error) {
    console.error("Error saving line item:", error);
    throw error;
  }
};

// More LineItem-related service functions can go here
