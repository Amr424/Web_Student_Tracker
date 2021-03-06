USE [master]
GO
/****** Object:  Database [web_student_tracker]    Script Date: 9/9/2018 1:24:57 PM ******/
CREATE DATABASE [web_student_tracker]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'web_student_tracker', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\web_student_tracker.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'web_student_tracker_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\web_student_tracker_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [web_student_tracker] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [web_student_tracker].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [web_student_tracker] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [web_student_tracker] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [web_student_tracker] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [web_student_tracker] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [web_student_tracker] SET ARITHABORT OFF 
GO
ALTER DATABASE [web_student_tracker] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [web_student_tracker] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [web_student_tracker] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [web_student_tracker] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [web_student_tracker] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [web_student_tracker] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [web_student_tracker] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [web_student_tracker] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [web_student_tracker] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [web_student_tracker] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [web_student_tracker] SET  ENABLE_BROKER 
GO
ALTER DATABASE [web_student_tracker] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [web_student_tracker] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [web_student_tracker] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [web_student_tracker] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [web_student_tracker] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [web_student_tracker] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [web_student_tracker] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [web_student_tracker] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [web_student_tracker] SET  MULTI_USER 
GO
ALTER DATABASE [web_student_tracker] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [web_student_tracker] SET DB_CHAINING OFF 
GO
ALTER DATABASE [web_student_tracker] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [web_student_tracker] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [web_student_tracker]
GO
USE [web_student_tracker]
GO
/****** Object:  Sequence [dbo].[hibernate_sequence]    Script Date: 9/9/2018 1:24:57 PM ******/
CREATE SEQUENCE [dbo].[hibernate_sequence] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[login]    Script Date: 9/9/2018 1:24:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[login](
	[Id] [int] NOT NULL,
	[user_name] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 CONSTRAINT [PK_login] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[student]    Script Date: 9/9/2018 1:24:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[student](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](50) NULL,
	[last_name] [varchar](50) NULL,
	[email] [varchar](50) NULL,
 CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [master]
GO
ALTER DATABASE [web_student_tracker] SET  READ_WRITE 
GO
