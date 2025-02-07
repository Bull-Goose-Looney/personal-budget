
import React, { useState } from 'react';
import LineItemCard from './LineItemCard';
import AddLineItemModal from './AddLineItemModal';

const LineItemList = ({ items, category, onAddLineItem, onEditLineItem, onDeleteLineItem }) => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  const lineItemListContainer = () => "p-4 bg-gray-100 flex flex-col items-center"; 
  const lineItemContainer = () => "flex flex-col gap-4 w-full max-w-3xl";
  const openModalButton = () => "mt-6 px-6 py-2 bg-green-500 text-white font-bold rounded-lg hover:bg-green-600 transition duration-200";

  return (
    <div className={lineItemListContainer()}>
      {/* Line Item List Container */}
      <div className={lineItemContainer()}>
        {Array.isArray(items) && items.length > 0 ? (
          items.map((item) => (
            <LineItemCard
              key={item.id}
              item={item}
              category={category}
              handleEdit={onEditLineItem}
              handleDelete={onDeleteLineItem}
            />
          ))
        ) : (
          <p>No items available</p> // Fallback if `items` is empty
        )}
      </div>
  
      {/* Modal component for adding a new line item */}
      {isModalOpen && (
        <AddLineItemModal
          categoryId
          onCancel={closeModal}
          onSubmit={(item) => {
            onAddLineItem(item);
          }}
        />
      )}
  
      {/* Button to open the modal */}
      <button onClick={openModal} className={openModalButton()}>
        Add Line Item
      </button>
    </div>
  );
};
export default LineItemList;

