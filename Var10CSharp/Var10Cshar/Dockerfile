FROM mcr.microsoft.com/dotnet/runtime:8.0 AS base
USER $APP_UID
WORKDIR /app

FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
ARG BUILD_CONFIGURATION=Release
WORKDIR /src
COPY ["Var10Cshar/Var10Cshar.csproj", "Var10Cshar/"]
RUN dotnet restore "Var10Cshar/Var10Cshar.csproj"
COPY . .
WORKDIR "/src/Var10Cshar"
RUN dotnet build "Var10Cshar.csproj" -c $BUILD_CONFIGURATION -o /app/build

FROM build AS publish
ARG BUILD_CONFIGURATION=Release
RUN dotnet publish "Var10Cshar.csproj" -c $BUILD_CONFIGURATION -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "Var10Cshar.dll"]
