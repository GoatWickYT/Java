fetch("https://youdosudoku.com/api/", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify({
    difficulty: "easy", // "easy", "medium", or "hard" (defaults to "easy")
    solution: true,
    array: false, // Végleges verzióban false lesz, azt kell értelmeznie a funkciónak
  }),
})
  .then((response) => {
    if (!response.ok) {
      throw new Error(`Error: ${response.status}`);
    }
    return response.json();
  })
  .then((data) => {
    console.log(data);
  })
  .catch((error) => {
    console.error(error);
  });
