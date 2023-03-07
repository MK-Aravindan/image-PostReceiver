import React, { useState } from "react";

const GetImage = () => {
  const [id, setId] = useState("");
  const [imageData, setImageData] = useState(null);

  const handleButtonClick = () => {
    fetch(`http://localhost:8080/images/${id}`)
      .then((response) => response.blob())
      .then((data) => setImageData(URL.createObjectURL(data)));
  };

  return (
    <div className="get">
      <div>
        <label htmlFor="idInput">Enter image ID:</label>
        <input
          id="idInput"
          type="text"
          value={id}
          onChange={(e) => setId(e.target.value)}
        />
        <button onClick={handleButtonClick}>Get Image</button>
      </div>
      {imageData && <img src={imageData} alt="" />}
    </div>
  );
};

export default GetImage;
