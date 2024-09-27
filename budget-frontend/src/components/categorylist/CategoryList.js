import React, { useState, useEffect } from 'react';
import { DragDropContext, Droppable } from 'react-beautiful-dnd';
import LineItemList from '../lineitemlist/LineItemList';
import { getCategories } from '../../services/categoryService'; // Import the service function

const CategoryList = () => {
  const [categories, setCategories] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        setLoading(true);
        const data = await getCategories();
        setCategories(data);
      } catch (err) {
        setError('Failed to fetch categories');
      } finally {
        setLoading(false);
      }
    };

    fetchCategories();
  }, []);

  const handleAddCategory = () => {
      console.log("todo call the backend");
  }

  const onDragEnd = (result) => {
    const { source, destination } = result;

    if (!destination) return;
    if (source.droppableId === destination.droppableId && source.index === destination.index) {
      return;
    }

    const sourceCategory = categories.find((category) => category.id.toString() === source.droppableId);
    const destCategory = categories.find((category) => category.id.toString() === destination.droppableId);

    const sourceItems = Array.from(sourceCategory.lineItems);
    const destItems = Array.from(destCategory.lineItems);

    const [movedItem] = sourceItems.splice(source.index, 1);
    destItems.splice(destination.index, 0, movedItem);

    const updatedCategories = categories.map((category) => {
      if (category.id.toString() === source.droppableId) {
        return { ...category, lineItems: sourceItems };
      }
      if (category.id.toString() === destination.droppableId) {
        return { ...category, lineItems: destItems };
      }
      return category;
    });

    setCategories(updatedCategories);
  };

  if (loading) {
    return <div>Loading categories...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div className="category-list-container">
      <h1>Category List</h1>
          <button
            type="button"
            className="flex-button"
            onClick={() => handleAddCategory()}  // Call handleSubmit
          >
           Add Category 
          </button>
      <DragDropContext onDragEnd={onDragEnd}>
        {categories.map((category) => (
          <Droppable key={category.id} droppableId={category.id.toString()}>
            {(provided) => (
              <div
                className='category-container'
                {...provided.droppableProps}
                ref={provided.innerRef}
              >
                <h2 className="category-header">{category.description}</h2>
                <LineItemList items={category.lineItems} />
                <div className="drag-placeholder">{provided.placeholder}</div>
              </div>
            )}
          </Droppable>
        ))}
      </DragDropContext>
    </div>
  );
};

export default CategoryList;

