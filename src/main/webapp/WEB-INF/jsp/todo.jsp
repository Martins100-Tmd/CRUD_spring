<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100">

    <div class="container mx-auto px-4 py-8">

        <!-- Header -->
        <div class="bg-white rounded-lg shadow-md p-6 mb-6">
            <h1 class="text-3xl font-bold text-center text-gray-800">
                Todo Dashboard {todos}
            </h1>
        </div>

        <!-- Add Todo -->
        <div class="bg-white rounded-lg shadow-md p-6 mb-6">

            <form method="post" action="/api/todo/add" class="flex gap-4">

                <input type="text" name="data" placeholder="Enter your todo..." class="flex-1 border p-3 rounded"
                    required>

                <button type="submit" class="bg-blue-600 text-white px-6 rounded">
                    Add Todo
                </button>

            </form>

        </div>

        <!-- Todo List -->
        <div class="grid gap-4 md:grid-cols-2 lg:grid-cols-3">

            <c:forEach var="todo" items="${todos}" varStatus="stat">

                <div class="bg-white rounded-lg shadow p-4">

                    <div class="flex justify-between mb-3">

                        <span>ID: ${todo.id}</span>

                        <span>${stat.count}</span>

                    </div>

                    <p class="mb-4">${todo.data}</p>

                    <div class="flex gap-2">

                        <form action="/delete/${todo.id}" method="post">

                            <button class="bg-red-600 text-white px-4 py-2 rounded">
                                Delete
                            </button>

                        </form>

                        <a href="/edit/${todo.id}" class="bg-yellow-500 text-white px-4 py-2 rounded">
                            Edit
                        </a>

                    </div>

                </div>

            </c:forEach>

        </div>

    </div>

</body>

</html>