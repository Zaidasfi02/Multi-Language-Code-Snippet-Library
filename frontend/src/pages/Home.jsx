import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const API_URL = "http://localhost:2026/api/codeSnippet";

const Home = () => {
  const [snippets, setSnippets] = useState([]);
  const [search, setSearch] = useState("");

  useEffect(() => {
    axios.get(API_URL).then((res) => setSnippets(res.data));
  }, []);

  const filteredSnippets = snippets.filter(
    (snippet) =>
      snippet.title.toLowerCase().includes(search.toLowerCase()) ||
      snippet.description.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="pt-20 p-6 min-h-screen bg-background text-textColor">
      {/* Search Bar */}
      <div className="mb-6">
        <input
          type="text"
          placeholder="🔍 Search by title or description..."
          className="w-full p-3 text-lg bg-gray-900 text-white rounded border border-secondary focus:outline-none focus:ring-2 focus:ring-secondary"
          onChange={(e) => setSearch(e.target.value)}
        />
      </div>

      {/* Displaying Search Results */}
      <h2 className="text-2xl font-bold text-secondary mb-4">All Snippets</h2>
      <div className="mt-6 space-y-4">
        {snippets.length > 0 ? (
          snippets.map((snippet) => (
            <div key={snippet.id} className="bg-gray-800 p-4 rounded shadow-lg">
              <h3 className="text-lg font-bold">{snippet.title}</h3>
              <p className="text-sm text-gray-400">{snippet.description}</p>
              <Link
                to={`/snippet/${snippet.id}`}
                className="text-secondary hover:underline"
              >
                View Code
              </Link>
            </div>
          ))
        ) : (
          <p className="text-gray-400">No snippets found.</p>
        )}
      </div>
    </div>
  );
};


export default Home;
