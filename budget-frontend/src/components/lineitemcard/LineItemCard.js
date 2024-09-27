import React, { useState } from 'react';
import './line_item_card.css'; // Import the corresponding CSS for the card

// Ok so you(the parent)just pass this component a function that does what you want.
const LineItemCard = ({ item, handleInputChange, handleSubmititem, handleDeleteitem }) => {
  const [isExpanded, setIsExpanded] = useState(false);

  // Toggle the card between expanded and collapsed
  const toggleExpand = () => {
    setIsExpanded((prev) => !prev);
  };

  const [formData, setFormData] = useState({
    description: '',
    plannedAmount: -1,
    nextDue: '',
    isAutoPay: false,
    frequency: '',
  })

  const handleCancel = () => {
    setIsExpanded(false);
  };

  const handleSubmit = () => {
    setIsExpanded(false);
  }


  return (
    <div className={`line-item-card ${isExpanded ? 'line-item-card-expanded' : ''}`}>
      {/* Move the onClick to a header or specific area */}
      <div className="line-item-header" onClick={toggleExpand}>
        <strong>Description:</strong> {item.description} - Click to {isExpanded ? 'Collapse' : 'Expand'}
      </div>

      {/* Display collapsed card summary */}
      <div>
        <strong>Planned Amount:</strong> ${item.plannedAmount.toFixed(2)}
      </div>
      <div>
        <strong>Next Due:</strong> {new Date(item.nextDue).toLocaleDateString()}
      </div>

      {/* Show expanded content when clicked */}
      {isExpanded && (
        <div className="line-item-card-expanded">
          <hr />
          <div className="line-item-form">
            <label>
              <strong>Description: </strong>
              <input
                type="text"
                value={item.description}
                onChange={(e) => handleInputChange(item.id, 'description', e.target.value)}
              />
            </label>
            <label>
              <strong>Planned Amount: </strong>
              <input
                type="number"
                value={item.plannedAmount}
                onChange={(e) => handleInputChange(item.id, 'plannedAmount', parseFloat(e.target.value))}
              />
            </label>
            <label>
              <strong>Next Due: </strong>
              <input
                type="date"
                value={new Date(item.nextDue).toISOString().split('T')[0]}
                onChange={(e) => handleInputChange(item.id, 'nextDue', e.target.value)}
              />
            </label>
            <label>
              <strong>Auto Pay: </strong>
              <input
                type="checkbox"
                checked={item.isAutoPay}
                onChange={(e) => handleInputChange(item.id, 'isAutoPay', e.target.checked)}
              />
            </label>
            <label>
              <strong>Frequency: </strong>
              <select
                value={item.frequency}
                onChange={(e) => handleInputChange(item.id, 'frequency', e.target.value)}
              >
                <option value="DAILY">Daily</option>
                <option value="WEEKLY">Weekly</option>
                <option value="MONTHLY">Monthly</option>
                <option value="YEARLY">Yearly</option>
              </select>
            </label>

            <div className="flex-container">
              <button
                type="button"
                className="flex-button"
                onClick={() => handleSubmit(item.id)}  // Call handleSubmit
              >
                Save
              </button>
              <button
                type="button"
                className="flex-button"
                onClick={handleCancel}  // Collapse on cancel
              >
                Cancel
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default LineItemCard;

