import React, { useState, useEffect } from 'react';
const Container = () => {
    useEffect(() =>{
      document.title="Container";
    },[]);
    return (
        <div>
          <p>Welcome!</p>
        </div>
    )
}

export default Container;