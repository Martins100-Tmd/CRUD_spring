<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello Page</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com">
    </script>
    <script>
        document.addEventListener("DOMContentLoaded", () => {
            const dateviewer = document.getElementById("clock");

            setInterval(() => {
                const date = new Date();
                // More readable format
                dateviewer.innerHTML = date.toLocaleString('en-US', {
                    weekday: 'long',
                    year: 'numeric',
                    month: 'long',
                    day: 'numeric',
                    hour: '2-digit',
                    minute: '2-digit',
                    second: '2-digit'
                });
            }, 1000);
        });
    </script>
</head>

<body class="bg-gradient-to-r from-purple-400 via-pink-500 to-red-500">
    <div class="min-h-screen flex items-center justify-center">
        <div
            class="bg-white bg-opacity-90 backdrop-blur-lg rounded-2xl shadow-2xl p-8 max-w-2xl mx-4 transform transition-all hover:scale-105">

            <!-- Header -->
            <div class="text-center mb-8">
                <h1
                    class="text-xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-purple-600 to-pink-600">
                    Spring Boot + JSP
                </h1>
                <div class="w-24 h-1 bg-gradient-to-r from-purple-600 to-pink-600 mx-auto mt-4 rounded-full"></div>
            </div>


            <p class="w-full my-3 text-sm text-center" id="clock"></p>

            <!-- Message Card -->
            <div class="flex flex-col items-center  rounded-xl p-6 mb-6 border-2 border-purple-200">
                <p class="text-base text-gray-700 leading-relaxed">
                    <span class="font-semibold text-purple-600">Name:</span>
                    ${name}
                </p>
                <p class="text-base text-gray-700 leading-relaxed">
                    <span class="font-semibold text-purple-600">Password:</span>
                    ${password}
                </p>
            </div>
            <!-- Action Buttons -->
            <div class="flex flex-wrap gap-3 justify-center">
                <a href="/page"
                    class="px-6 py-2 bg-purple-600 hover:bg-purple-700 text-white rounded-lg transition duration-200 shadow-md hover:shadow-lg transform hover:-translate-y-0.5">
                    Go to Home
                </a>
                <a href="/martins"
                    class="px-6 py-2 bg-pink-600 hover:bg-pink-700 text-white rounded-lg transition duration-200 shadow-md hover:shadow-lg transform hover:-translate-y-0.5">
                    About Martins
                </a>
            </div>
        </div>
    </div>
</body>

</html>