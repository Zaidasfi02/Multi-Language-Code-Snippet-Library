import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const API_URL = "http://localhost:2026/api/codeSnippet";

const AddSnippet = () => {
  const [title, setTitle] = useState("");
  const [language, setLanguage] = useState("");
  const [code, setCode] = useState("");
  const [description, setDescription] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post(`${API_URL}/add`, { title, language, code, description })
      .then(() => {
        alert("Snippet Added Successfully!");
        setTitle("");
      setLanguage("");
      setCode("");
      setDescription("");
        navigate("/");
      });
  };

  return (
    <div className="pt-20 p-6 min-h-screen bg-background text-textColor flex justify-center items-center">
      <div className="bg-gray-900 p-8 rounded-lg shadow-xl w-full max-w-lg">
        <h1 className="text-3xl text-amber-200 font-bold text-secondary mb-6 text-center">
          Add a New Snippet
        </h1>
        <form onSubmit={handleSubmit} className="space-y-4">
          <input
            className="w-full p-3 bg-gray-800 text-white rounded focus:outline-none focus:ring-2 focus:ring-secondary"
            placeholder="Snippet Title"
            onChange={(e) => setTitle(e.target.value)}
            required
          />
          <input
            className="w-full p-3 bg-gray-800 text-white rounded focus:outline-none focus:ring-2 focus:ring-secondary"
            placeholder="Programming Language"
            onChange={(e) => setLanguage(e.target.value)}
            required
          />
          <textarea
            className="w-full p-3 bg-gray-800 text-white rounded focus:outline-none focus:ring-2 focus:ring-secondary h-40"
            placeholder="Snippet Code"
            onChange={(e) => setCode(e.target.value)}
            required
          />
          <input
            className="w-full p-3 bg-gray-800 text-white rounded focus:outline-none focus:ring-2 focus:ring-secondary"
            placeholder="Description (optional)"
            onChange={(e) => setDescription(e.target.value)}
          />
          <button className="w-full bg-gradient-to-r from-green-400 to-green-600 text-white p-3 rounded-full shadow-lg hover:scale-110 hover:bg-green-700 transition-transform duration-200 cursor-pointer">
            Submit Snippet
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddSnippet;