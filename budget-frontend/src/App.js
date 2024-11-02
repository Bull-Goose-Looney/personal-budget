import React from 'react';
import CategoryList from './components/CategoryList';

function App() {
  return (
    <div className="App min-h-screen bg-gray-100 flex flex-col items-center justify-center">
      <header className="App-header w-full max-w-3xl p-4 bg-white shadow-md rounded-lg">
        <h1 className="text-3xl font-bold text-center text-gray-800 mb-6">
          Category List
        </h1>
        <CategoryList /> 
      </header>
    </div>
  );
}

export default App;
