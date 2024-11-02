import React, { useState } from 'react';
import LineItemList from './LineItemList';
import { saveLineItem } from '../services/lineItemService'

const Category = ({ category }) => {
const [lineItems, setLineItems] = useState(category.lineItems);

const handleAddLineItem = async (newItem) => {
  try {
    const itemWithCategory = {...newItem, category: category.id}
    const savedItem = await saveLineItem(itemWithCategory);
    setLineItems((prevLineItems) => [...prevLineItems, savedItem]);
  } catch (error) {
    console.error("Failed to save line item:", error);
    alert("There was an error saving the line item. Please try again.");
  }
};

  const handleEditLineItem = (updatedItem) => {
    setLineItems((prevLineItems) =>
      prevLineItems.map((item) => (item.id === updatedItem.id ? updatedItem : item))
    );
  };

  // Function to delete a line item by its ID
  const handleDeleteLineItem = (itemId) => {
    setLineItems((prevLineItems) =>
      prevLineItems.filter((item) => item.id !== itemId)
    );
  };

  const categoryContainer = () => "p-4 bg-white shadow-md rounded-lg mb-4"; 
  const categoryHeader = () => "text-2xl font-bold mb-2 pb-2 border-b-2 border-gray-300"

  return (
    <div className={categoryContainer()}>
      <h2 className={categoryHeader()}>
        {category.description}
      </h2>
      
      {/* Render the LineItemList for this category's line items */}
      <LineItemList
        items={lineItems}
        categoryId={category}
        onAddLineItem={handleAddLineItem}  // Pass function to add a line item
        onEditLineItem={handleEditLineItem}    // Pass function to edit a line item
        onDeleteLineItem={handleDeleteLineItem}
      />
    </div>
  );
};

export default Category;
