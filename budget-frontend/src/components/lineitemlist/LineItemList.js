import { Draggable } from 'react-beautiful-dnd';
import LineItemCard from '../lineitemcard/LineItemCard'; // Import the new LineItemCard component
import './line_item_list.css';

import React, { useState } from 'react';

const LineItemList = () => {
  // State to manage the list of items
  const [items, setItems] = useState([
    {
      id: 1,
      description: 'Rent',
      plannedAmount: 1000,
      nextDue: '2023-10-01',
      isAutoPay: true,
      frequency: 'MONTHLY',
    },
    {
      id: 2,
      description: 'Gym Membership',
      plannedAmount: 50,
      nextDue: '2023-10-05',
      isAutoPay: false,
      frequency: 'MONTHLY',
    },
    // Add more items as needed
  ]);

  // Function to handle input changes
  const handleInputChange = (id, field, value) => {
    // Update the state of the specific item in the list
    setItems((prevItems) =>
      prevItems.map((lineitem) =>
        lineitem.id === id ? { ...lineitem, [field]: value } : lineitem
      )
    );
  };

  // Function to handle form submission
  const handleSubmitLineItem = (id) => {
    const submittedItem = items.find((lineitem) => lineitem.id === id);

    if (submittedItem) {
      // Validation example: Ensure description is filled out
      if (!submittedItem.description || submittedItem.plannedAmount <= 0) {
        alert('Please fill in valid values for description and planned amount.');
        return;
      }

      console.log('Submitted item:', submittedItem);
      

      // This will call Category.update() Old one will be updated to match the new one.
      alert('Item saved successfully!');

      // Close the card here. not sure how.
    }
  };

  return (
    <div>
      <div className='card-command-header-container'>
        <button>1</button> 
        <button>2</button> 
        <button>3</button> 
        <button>4</button> 
      </div>
      {items.map((item) => (
        <LineItemCard
          key={item.id}
          item={item}
          handleInputChange={handleInputChange}
          handleSubmitLineItem={handleSubmitLineItem}
        />
      ))}
    </div>
    
  );
};


export default LineItemList;
