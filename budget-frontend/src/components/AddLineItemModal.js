import React, { useState } from 'react';

// Define class constants
const modalBackdrop = "fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50";
const modalContainer = "bg-white p-6 rounded-lg shadow-lg w-80 text-left";
const modalTitle = "text-2xl font-bold mb-4 text-center";
const inputField = "p-2 border border-gray-300 rounded mt-1";
const buttonContainer = "flex justify-end mt-6 space-x-4";
const saveButton = "px-4 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600";
const cancelButton = "px-4 py-2 bg-red-500 text-white rounded-lg hover:bg-red-600";

const AddLineItemModal = ({ category, onSubmit, onCancel }) => {
  const [description, setDescription] = useState('');
  const [plannedAmount, setPlannedAmount] = useState(0);
  const [nextDue, setNextDue] = useState('');
  const [isAutoPay, setIsAutoPay] = useState('');
  const [frequency, setFrequency] = useState('MONTHLY');

  const handleSubmit = () => {
    const newItem = {
      id: Date.now(),  // Example ID, use something unique
      description,
      plannedAmount,
      nextDue,
      isAutoPay,
      frequency,
      category,
    };
    onSubmit(newItem);
    onCancel();
    setDescription('');
    setPlannedAmount(0);
    setNextDue('');
    setIsAutoPay('');
    setFrequency('');
  };

  // Close modal if user clicks outside the content
  const handleBackdropClick = (e) => {
    if (e.target === e.currentTarget) {
      onCancel();
    }
  };

  return (
    <div className={modalBackdrop} onClick={handleBackdropClick}>
      <div className={modalContainer}>
        <h2 className={modalTitle}>Add Line Item</h2>

        <div className="flex flex-col gap-4">
            <label className="flex flex-col">
              <strong>Description: </strong>
              <input
                type="text"
                className={inputField}
                value={description}
                onChange={(e) => setDescription(e.target.value)}
              />
            </label>

            <label className="flex flex-col">
              <strong>Planned Amount: </strong>
              <input
                type="number"
                className={inputField}
                value={plannedAmount}
                onChange={(e) => setPlannedAmount(parseFloat(e.target.value))}
              />
            </label>

            <label className="flex flex-col">
              <strong>Next Due: </strong>
              <input
                type="date"
                className={inputField}
                value={nextDue}
                onChange={(e) => setNextDue(e.target.value)}
              />
            </label>

            <label className="flex items-center">
              <strong>Auto Pay: </strong>
              <input
                type="checkbox"
                className="ml-2"
                checked={isAutoPay}
                onChange={(e) => setIsAutoPay(e.target.checked)}
              />
            </label>

            <label className="flex flex-col">
              <strong>Frequency: </strong>
              <select
                className={inputField}
                value={frequency}
                onChange={(e) => setFrequency(e.target.value)}
              >
                <option value="DAILY">Daily</option>
                <option value="WEEKLY">Weekly</option>
                <option value="MONTHLY">Monthly</option>
                <option value="YEARLY">Yearly</option>
              </select>
            </label>
        </div>

        <div className={buttonContainer}>
          <button onClick={handleSubmit} className={saveButton}>
            Save
          </button>
          <button onClick={onCancel} className={cancelButton}>
            Cancel
          </button>
        </div>
      </div>
    </div>
  );
};

export default AddLineItemModal;
