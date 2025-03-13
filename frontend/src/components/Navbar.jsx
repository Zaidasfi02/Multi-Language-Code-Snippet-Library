import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="fixed top-0 w-full bg-primary text-textColor p-4 flex justify-between items-center shadow-lg z-10">
      <Link to="/" className="text-2xl font-bold">Code Snippet Library</Link>
      <Link to="/add" className="bg-gradient-to-r from-green-400 to-green-600 text-white px-5 py-2 rounded-full shadow-lg hover:scale-110 hover:bg-green-700 transition-transform duration-200 cursor-pointer">
        ➕ Add Snippet
      </Link>
    </nav>
  );
};
export default Navbar;
