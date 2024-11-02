import React, { useEffect, useState } from 'react';
import { fetchCategories } from '../services/categoryService'
import Category from './Category'

const CategoryList = () => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    const loadCategories = async () => {
      try {
        const data = await fetchCategories();
        setCategories(data);
      } catch (error) {
        console.error("Failed to fetch categories:", error);
      }
    };
    loadCategories();

  }, []);

  const handleAddCategory = () => {

  }

  const categoryListContainer = () => "mb-5 p-2 border border-gray-300 rounded-lg bg-gray-100";
  const addCategoryButton = () => "px-5 py-2 text-lg border-none bg-green-500 text-white rounded cursor-pointer hover:bg-green-700"

  return (
    <div className={categoryListContainer()}>
      <button
        type="button"
        className={addCategoryButton()}
        onClick={handleAddCategory}
      >
        Add Category
      </button>
      {/* Render each Category component */}
      {categories.map((category) => (
        <Category key={category.id} category={category} />
      ))}
    </div>
  );
};

export default CategoryList;


