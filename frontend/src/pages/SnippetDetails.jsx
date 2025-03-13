import React, { useState, useEffect } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";
import axios from "axios";

const API_URL = "http://localhost:2026/api/codeSnippet";

const SnippetDetails = () => {
  const { id } = useParams();
  const [snippet, setSnippet] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get(`${API_URL}/${id}`).then((res) => setSnippet(res.data));
  }, [id]);

  const handleDelete = () => {
    if (window.confirm("Are you sure you want to delete this snippet?")) {
      axios.delete(`${API_URL}/${id}`).then(() => {
        alert("Snippet Deleted Successfully!");
        navigate("/");
      });
    }
  };

  return snippet ? (
    <div className="pt-20 p-6 min-h-screen bg-background text-textColor">
      <h1 className="text-3xl font-bold">{snippet.title}</h1>
      <p className="text-secondary">{snippet.language}</p>
      <pre className="bg-gray-900 p-4 rounded mt-4 text-white">
        <code>{snippet.code}</code>
      </pre>

      <div className="flex mt-4 space-x-4">
        <Link
          to={`/edit/${snippet.id}`}
          className="bg-yellow-500 px-4 py-2 rounded shadow-lg hover:scale-110 transition-transform duration-200 cursor-pointer"
        >
          Edit
        </Link>
        <button
          onClick={handleDelete}
          className="bg-red-500 px-4 py-2 rounded shadow-lg hover:scale-110 transition-transform duration-200 cursor-pointer"
        >
          Delete
        </button>
      </div>
    </div>
  ) : (
    <p>Loading...</p>
  );
};

export default SnippetDetails;