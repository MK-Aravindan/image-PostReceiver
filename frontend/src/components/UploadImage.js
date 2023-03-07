import React, { useState } from "react";
import { Link } from "react-router-dom";

const UploadImage = () => {
  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileInput = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleUploadClick = () => {
    const formData = new FormData();
    formData.append("image", selectedFile);

    fetch("http://localhost:8080/upload-image", {
      method: "POST",
      body: formData,
    })
      .then((response) => {
        if (response.ok) {
          console.log("Image uploaded successfully!");
        } else {
          console.error("Error uploading image");
        }
      })
      .catch((error) => console.error(error));
  };

  return (
    <div className="upload">
      <input type="file" onChange={handleFileInput} />
      <button onClick={handleUploadClick}>Upload</button> <br />
      <Link to="/images">Get Images</Link>
    </div>
  );
};

export default UploadImage;
