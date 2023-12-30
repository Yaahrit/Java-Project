<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Mvc Lecture</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align:center;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Welcome to Telusko</h1>
    <form action="addAlien" method="post">
        <label for="num1">Enter your id :</label>
        <input type="text" name="aid" id="num1" /><br>
        <label for="num2">Enter your name :</label>
        <input type="text" name="aname" id="num2" /><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
