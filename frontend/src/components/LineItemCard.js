import React, { useState } from 'react';

// Class name constants
const cardContainer = "p-4 mb-4 bg-white text-black border border-gray-300 rounded-lg shadow-md transition-shadow duration-200 hover:shadow-lg";
const headerContainer = "cursor-pointer";
const inputField = "p-2 w-full border border-gray-300 rounded";
const divider = "border-t border-gray-600 mb-3";
const buttonContainer = "flex justify-end mt-4";
const buttonBase = "px-4 py-2 text-lg text-white rounded cursor-pointer";
const saveButton = `${buttonBase} bg-green-500 hover:bg-green-700`;

const LineItemCard = ({ item, handleEditLineItem }) => {
  const [isExpanded, setIsExpanded] = useState(false);
  const [description, setDescription] = useState(item.description);
  const [plannedAmount, setPlannedAmount] = useState(item.plannedAmount);
  const [nextDue, setNextDue] = useState(new Date(item.nextDue));
  const [isAutoPay, setIsAutoPay] = useState(item.isAutoPay);
  const [frequency, setFrequency] = useState(item.frequency);

  // Toggle between expanded and collapsed
  const toggleExpand = () => setIsExpanded((prev) => !prev);

  const handleSave = () => {
    const updatedItem = {
      ...item,
      description,
      plannedAmount,
      nextDue: nextDue ? new Date(nextDue.toISOString()) : null,
      isAutoPay,
      frequency,
    };
    handleEditLineItem(updatedItem); // Send the updated item back to the parent component
    setIsExpanded(false); // Optionally collapse after saving
  };

  return (
    <div className={`${cardContainer} ${isExpanded ? 'mt-2' : ''}`}>
      {/* Header - Expandable area */}
      <div className={headerContainer} onClick={toggleExpand}>
        <strong>Description:</strong> {item.description} - Click to {isExpanded ? 'Collapse' : 'Expand'}
      </div>

      {/* Display collapsed card summary */}
      {!isExpanded && (
        <div>
          <div>
            <strong>Planned Amount:</strong> ${item.plannedAmount.toFixed(2)}
          </div>
          <div>
            <strong>Next Due:</strong> {new Date(item.nextDue).toLocaleDateString()}
          </div>
        </div>
      )}

      {/* Expanded content - Editable form */}
      {isExpanded && (
        <div className="mt-4">
          <hr className={divider} />
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

            {/* Save Button */}
            <div className={buttonContainer}>
              <button type="button" className={saveButton} onClick={handleSave}>
                Save
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default LineItemCard;
