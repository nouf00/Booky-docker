import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import CardActionArea from '@mui/material/CardActionArea';
import CardActions from '@mui/material/CardActions';
import Pagination from '@mui/material/Pagination';
import Box from '@mui/material/Box';
import { useEffect, useState } from 'react';

export default function MainBook() {
  const [Book, setBook] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [booksPerPage , setbooksPerPage] = useState(6);

  useEffect(() => {
    const fetchBook = async () => {
      const request = await fetch('http://localhost:8080/api/newbook/books');
      if (request.status === 200) {
        const data = await request.json();
        setBook(data);
      }
    };
    fetchBook();
  }, []);

  const lastBookIndex = currentPage * booksPerPage;
  const firstBookIndex = lastBookIndex - booksPerPage;
  const currentBooks = Book.slice(firstBookIndex, lastBookIndex);

  const handleChangePage = (event, value) => {
    setCurrentPage(value);
  };

  return (
    <Box display="flex" flexDirection="column" alignItems="center" gap={4} mt={10} p={5}>
      <Box
        display="grid"
        gridTemplateColumns="repeat(3, 1fr)"
        gap={4}
        width="100%"
      >
        {currentBooks.map((book) => (
          <Card id={book.isbn} key={book.isbn} sx={{ maxWidth: 345, height: 'auto' }}>
            <CardActionArea>
              <CardMedia
                component="img"
                height="200"
                image={book.cover}
                alt="Book cover"
                sx={{ objectFit: "contain" }}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  Title: {book.title}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  Author: {book.author}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  ISBN: {book.isbn}
                </Typography>
              </CardContent>
            </CardActionArea>
            <CardActions>
              <Button size="small" color="primary">
                Number Of Pages: {book.numberPage}
              </Button>
            </CardActions>
          </Card>
        ))}
      </Box>

      <Pagination
        count={Math.ceil(Book.length / booksPerPage)}
        page={currentPage}
        onChange={handleChangePage}
        variant="outlined"
        sx={{ mt: 4 }}
      />
    </Box>
  );
}
