import React, { useEffect, useState } from 'react';
import { fetchCategories, addCategory } from '../services/categoryService'
import Category from './Category'

const CategoryList = () => {
  const [categories, setCategories] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const loadCategories = async () => {
      try {
        const data = await fetchCategories();
        setCategories(data);
      } catch (error) {
        console.error("Failed to fetch categories:", error);
        setError("Failed to load categories");
      } finally {
        setLoading(false);
      }
    };
    loadCategories();
  }, []);

  if (loading) return <p>Loading categories...</p>;
  if (error) return <p>{error}</p>;

  // const handleAddCategory = async (newCategory) => {
  //   try {
  //     const savedCategory = await addCategory(newCategory); // Call the API to save the category
  //     setCategories((prevCategories) => [...prevCategories, savedCategory]); // Add to the state
  //     // closeAddCategoryModal(); // Close the modal after successful addition
  //   } catch (error) {
  //     console.error("Failed to add category:", error);
  //     alert("There was an error adding the category. Please try again.");
  //   }
  // };

  const categoryListContainer = () => "mb-5 p-2 border border-gray-300 rounded-lg bg-gray-100";
  const addCategoryButton = () => "px-5 py-2 text-lg border-none bg-green-500 text-white rounded cursor-pointer hover:bg-green-700"

  return (
    <div className={categoryListContainer()}>
      <button
        type="button"
        className={addCategoryButton()}
        // onClick={handleAddCategory()}
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


