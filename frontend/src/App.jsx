import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import SnippetDetails from "./pages/SnippetDetails";
import AddSnippet from "./pages/AddSnippet";

const App = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/add" element={<AddSnippet />} />
        <Route path="/snippet/:id" element={<SnippetDetails />} />
      </Routes>
    </Router>
  );
};

export default App;
